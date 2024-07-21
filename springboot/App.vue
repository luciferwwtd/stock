<template>
  
  
  <!-- _____________________________________________________________________________________________ weather -->

  
  <!-- <input v-model="city" placeholder="이걸 본 너는 바보가 된다">
  <button @click="weatherLoad()">조회하기</button>

  

  <div>
    <table style="width:60%; height: 100px; margin: auto; text-align: center;">
      <tr>
        <th>날짜</th>
        <th>날씨</th>
        <th>최저 온도</th>
        <th>최고 온도</th>
      </tr>
      <tr v-for="item in items" :key="item.title">
        <td><span v-html="item.날짜"></span></td>
        <td><span v-html="item.날씨"></span></td>
        <td><span v-html="item.최저온도"></span></td>
        <td><span v-html="item.최고온도"></span></td>
      </tr>
    </table>
  </div> -->

  <!-- _____________________________________________________________________________________________ weather -->


  <!-- _____________________________________________________________________________________________ disease -->

<input v-model="date" placeholder="날짜를 입력하세요(2019년부턴 안됨 내 맘임 ㅗㅗ)">
<input v-model="city" placeholder="도시를 입력하세요">
<input v-model="disease" placeholder="질병을 입력하세요">
<button @click="diseaseLoad()">조회하기</button>

  <div>
    <table style="width:60%; height: 100px; margin: auto; text-align: center;">
      <tr>
        <th>지역</th>
        <th>발생 건수</th>
      </tr>
      <tr v-for="item in items" :key="item.title">
        <td><span v-html="item.날짜"></span></td>
        <td><span v-html="item.날씨"></span></td>
      </tr>
    </table>
  </div>

  <!-- _____________________________________________________________________________________________ disease -->

</template>


<script>
import axios from 'axios';
// import Movie from './components/Movie.vue'
// import Test from './components/Test.vue'

export default {
  name: 'App',
  components: {
    // Movie
    // Test
  },
  data() {
    return {
      errors: [],
      items: [],

      threadPool: [],
      date: "",
      city: "",
      disease: ""
    }
  },
  mounted() {
    this.test()
  },
  methods: {
    test() {
      // var array = [];
      // var dict = {
      //   "날씨": "value1",
      //   "날짜": "value2"
      // };

      // array.push(dict);
      // console.log(array);
      // Repeat this last part as needed to add more key/value pairs
    },
    diseaseLoad() {
      console.log('/api/disease/'+this.city+'/'+this.disease+'/'+this.date);
      
      axios.get('/api/disease/'+this.city+'/'+this.disease+'/'+this.date)
        .then(response => (response.data))
        .then(result => {
          console.log("Yatta!")
          
          // // JSON responses are automatically parsed.
          // this.threadPool = result;
          // this.items = [];

          // var dict = {};

          // for (var i = 0; i < this.threadPool.length; i++) {
          //   dict = {
          //     날짜: this.threadPool[i][0],
          //     날씨: this.threadPool[i][1],
          //     최저온도: this.threadPool[i][2],
          //     최고온도: this.threadPool[i][3],
          //   };

          //   console.log(dict);

          //   // this.dic["날짜"] = this.threadPool[i][0];
          //   // this.dic["날씨"] = this.threadPool[i][1];
          //   // this.dic["최저 온도"] = this.threadPool[i][2];
          //   // this.dic["최고 온도"] = this.threadPool[i][3];
          //   this.items.push(dict);
          //   console.log(this.items);
          // }

          // return this.items
        })
        .catch(e => {
          this.errors.push(e)
        })
    },
    weatherLoad() {
    	axios.get('/api/city/'+this.city)
        .then(response => (response.data))
        .then(result => {
          
          // JSON responses are automatically parsed.
          this.threadPool = result;
          this.items = [];

          var dict = {};

          for (var i = 0; i < this.threadPool.length; i++) {
            dict = {
              날짜: this.threadPool[i][0],
              날씨: this.threadPool[i][1],
              최저온도: this.threadPool[i][2],
              최고온도: this.threadPool[i][3],
            };

            console.log(dict);

            // this.dic["날짜"] = this.threadPool[i][0];
            // this.dic["날씨"] = this.threadPool[i][1];
            // this.dic["최저 온도"] = this.threadPool[i][2];
            // this.dic["최고 온도"] = this.threadPool[i][3];
            this.items.push(dict);
            console.log(this.items);
          }

          return this.items
        })
        .catch(e => {
          this.errors.push(e)
        })
	  }
  }
}
</script>

<style>
#app {
  td, th {
    padding: 10px;
    border: 1px solid #ccc;
  }
  body {
  padding: 1rem;
  }
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
