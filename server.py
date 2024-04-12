import socket
import pymongo

HOST = "10.0.2.2"  # 10.0.2.2 is the pc himself
PORT = 1234  

def Connect(ip, port):
  with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
      print('Waiting')
      s.bind((HOST, PORT))
      s.listen()
      conn, addr = s.accept()
      with conn:
          print(f"Connected by {addr}")
          while True:
              data = conn.recv(1024)
              if not data:
                  break
              conn.sendall(data)

def mongo():
    client = pymongo.MongoClient("mongodb://localhost:27017")
    user_database = client["Users"]
    info_collection = user_database["info"]

def main():
  mongo()

if __name__ == "__main__":
    main()
