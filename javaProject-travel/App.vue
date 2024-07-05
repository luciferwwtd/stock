<template>
  <img alt="Vue logo" src="./assets/logo.png">
  <input v-model="city" placeholder="지역 이름">
  <button @click="initLoad()">조회하기</button>

  <b-table striped hover :items="items"></b-table>

</template>

<!-- <template>
  <div class="test">
    <div id="demo">
        <button @click="travelLoad()">조회하기</button>
    </div>
  </div>
</template> -->


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
      city: "",
      dic: {},
      travDic: {},
      travelList: [],
    }
  },
  mounted() {
    this.travelLoad();
    this.initLoad();
  },
  methods: {
    travelLoad() {
        axios.get('/api/travel/'+this.city)
        .then(response => (response.data))
        .then(result => {
            this.threadPool = result;

            for (var i = 0, i < this.threadPool.length, i++) {
                this.travDic["관광지 이름"] = this.threadPool[i][1];
                this.travDic["설명"] = this.threadPool[i][2];
            }
        })
        .catch(e => {
          this.errors.push(e)
        })
    },
    initLoad() {
    	axios.get('/api/city/'+this.city)
        .then(response => (response.data))
        .then(result => {
          
          // JSON responses are automatically parsed.
          this.threadPool = result;

          for (var i = 0; i < this.threadPool.length; i++) {
            this.dic["날짜"] = this.threadPool[i][0];
            this.dic["날씨"] = this.threadPool[i][1];
            this.dic["최저 온도"] = this.threadPool[i][2];
            this.dic["최고 온도"] = this.threadPool[i][3];
            console.log(this.dic);
            this.item.push(this.dic);
            console.log("item : "+this.item);
            this.dic.container = {};

            console.log("dic : "+this.dic)
          }
        })
        .catch(e => {
          this.errors.push(e)
        })
	  },
    click() {

    } 
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
