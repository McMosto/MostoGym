import socket
import pymongo

"10.0.2.2"  # 10.0.2.2 is the pc himself1234


def ConnectSocket(ip, port, collection):
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        print('Waiting')
        s.bind(('0.0.0.0', port))
        s.listen()
        msg = ""
        while msg != "CONT\r\n":
            conn, addr = s.accept()
            with conn:
                print(f"Connected by {addr}")
                while True:
                    data = conn.recv(1024)
                    print(f"Received: {data}")
                    msg = check_data(data,collection) + "\r\n"
                    if not data:
                        break
                    conn.send(msg.encode())
                    print(f"Sent: {msg}")
                    s.close()


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




def main():
    info_collection = ConnectToMongoDB()
    ConnectSocket("10.0.2.2" , 37261, info_collection) # 10.0.2.2 is the pc himself


if __name__ == "__main__":
    main()
