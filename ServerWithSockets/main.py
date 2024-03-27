import socket
import pymongo
import threading

def ConnectToMongoDB():
    client = pymongo.MongoClient("mongodb://localhost:27017")
    user_database = client["Users"]
    info_collection = user_database["info"]
    return info_collection

def check_data(string, collection):
    string = string[2:].decode()
    sort = string.split('-')
    type = sort[0]
    print(sort)
    email = sort[1]
    password = sort[2]
    print(type)
    if type == "login":
        user = collection.find_one({"email": email.strip(), "password": password.strip()})
        if user:
            return "CONT"
        else:
            return "ERRR: login isn't successful"
    elif type == "signu":
        #check if something already used
        first_name = sort[3]
        last_name = sort[4]
        nickname = sort[5]
        if collection.find_one({"email": email}):
            return "ERRR: email is already used"
        elif collection.find_one({"nickname": nickname}):
            return "ERRR: nickname is already used"
        else:
            user_data = {
                "email": email,
                "password": password,
                "first_name": first_name,
                "last_name": last_name,
                "nickname": nickname
            }

            collection.insert_one(user_data)
            return "CONT"
    elif type == "newwo":
        return ""
    else:
        return "ERRR: didn't get an understandable string"

def handle_client(conn, addr, collection):
    with conn:
        print(f"Connected by {addr}")
        msg = ""
        while msg != "CONT\r\n":
            data = conn.recv(1024)
            if not data:
                break
            print(f"Received: {data}")
            msg = check_data(data, collection) + "\r\n"
            conn.send(msg.encode())
            print(f"Sent: {msg}")
        print("Client disconnected")

def server_thread(ip, port, collection):
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.bind((ip, port))
        s.listen()
        print('Server is listening...')
        while True:
            conn, addr = s.accept()
            threading.Thread(target=handle_client, args=(conn, addr, collection)).start()

def main():
    info_collection = ConnectToMongoDB()
    server_thread("192.168.1.27", 37261, info_collection)

if __name__ == "__main__":
    main()
