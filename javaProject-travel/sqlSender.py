import pymysql.cursors
import sys

from PyQt5.QtWidgets import *
from PyQt5.QtCore import *
 
class MyWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.initUI()
 
    def initUI(self):
        self.setWindowTitle('뚜따 프로그램')
        self.setGeometry(200, 200, 360, 100)
 
        self.placeEdit = QLineEdit("", self)
        self.placeEdit.move(20, 50)

        self.nameEdit = QLineEdit("", self)
        self.nameEdit.move(20, 50)

        self.descEdit = QLineEdit("", self)
        self.descEdit.move(20, 50)
 
        button2 = QLineEdit("전송하기", self)
        button2.move(130, 50)
        button2.clicked.connect(self.button2Clicked)
 
    def button2Clicked(self):
        
      conn = pymysql.connect(host='183.99.87.90',
        user='root',
        password=swhacademy!,
        db='swhdb',
        charset='utf8')
      try:
        with conn.cursor() as cursor:
          sql = "INSERT INTO travel (place, name, desc) VALUES ('%s', '%s', '%s')" % (placeEdit.text(), nameEdit.text(), descEdit())
          print(sql)
          cursor.execute(sql)
          # sql = 'INSERT INTO users (email, password) VALUES (%s, %s)'
          # cursor.execute(sql, ('test@test.com', 'my-passwd'))
        conn.commit()
        print(cursor.lastrowid)
        # 1 (last insert id)
      finally:
        conn.close()
        
if __name__ == "__main__":
  app = QApplication(sys.argv)
  window = MyWindow()
  window.show()
  sys.exit(app.exec_())
