from flask import Flask, redirect, url_for, request, render_template
import pymysql.cursors

app = Flask(__name__)


@app.route('/welcome/<name>')
def welcome(name):
    return '%s님 환영합니다.' % name


@app.route('/', methods=['GET'])  # methods = ['GET', 'POST']) 로 여러 개 가능
def login():
    placeValues = []
    conn = pymysql.connect(host='183.99.87.90',
                           user='root',
                           password="swhacademy!",
                           db='SeanLee',
                           charset='utf8')

    with conn.cursor() as cursor:
        sql = 'SELECT place FROM travel;'
        cursor.execute(sql)
        results = cursor.fetchall()
        for result in results:
            placeValues.append(result)
    return render_template('render_template.html', placeValuess=placeValues)


@app.route('/submit', methods=['POST'])
def submit():
    travelValues = []
    travelResult = []

    weatherValues = []
    weatherResult = []

    placeValues = []
    i=0
    if request.method == 'POST':
        user = request.form['place']
        # return redirect(url_for('welcome', name=user))
        conn = pymysql.connect(host='183.99.87.90',
                               user='root',
                               password="swhacademy!",
                               db='SeanLee',
                               charset='utf8')
        try:
            with conn.cursor() as cursor:
                sql = 'SELECT * FROM travel WHERE place = "%s";' % (user)
                cursor.execute(sql)
                results = cursor.fetchall()
                # for result in results:
                while i<len(results):
                    travelResult.append(results[i][1])
                    travelResult.append(results[i][2])
                    travelValues.append(travelResult)
                    travelResult = []
                    i += 1
            with conn.cursor() as cursor:
                sql = 'SELECT * FROM weather WHERE place = "%s";' % (user)
                cursor.execute(sql)
                results = cursor.fetchall()
                # for result in results:
                while i<len(results):
                    weatherResult.append(results[i][0])
                    weatherResult.append(results[i][1])
                    weatherResult.append(results[i][3])
                    weatherResult.append(results[i][4])
                    weatherValues.append(weatherResult)
                    weatherResult = []
                    i += 1

            with conn.cursor() as cursor:
                sql = 'SELECT place FROM travel;'
                cursor.execute(sql)
                results = cursor.fetchall()
                for result in results:
                    placeValues.append(result)
            return render_template('render_template.html', values=travelValues, weatherValuess=weatherValues, placeValuess=placeValues)
                # (1, 'test@test.com', 'my-passwd')
        finally:
            conn.close()



if __name__ == '__main__':
    app.run(host="127.0.0.1", port="8080")
