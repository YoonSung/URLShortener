import sys
import MySQLdb
from rdbtools import RdbParser, RdbCallback

db = MySQLdb.connect(host="10.73.45.56", user="root", passwd="dddd!!@@##$$", db="shortener")
sur = db.cursor()
sql = "delete from redis"
sur.execute(sql)

class MyCallback(RdbCallback) :

    def insert(test,query) :
        cur = db.cursor()
        cur.execute(query)
        db.commit()

    def hset(self, key, field, value):
        if(key=="URLShortener") :
            sql = "INSERT into redis(redis_key, redis_value) values(\'%d\', \'%s\')" % (int(field), value)
            self.insert(sql)

callback = MyCallback()
parser = RdbParser(callback)
parser.parse('/home/next/data/dump.rdb')
db.close()