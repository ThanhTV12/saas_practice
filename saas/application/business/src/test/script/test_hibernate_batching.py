#!/usr/bin/python
import requests

#Request B Update
response = requests.post("http://localhost:8080/user")
print "User A user:", response.json()


response = requests.post("http://localhost:8080/user")
print "User B user:", response.json()




