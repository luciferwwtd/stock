<template>
  <div class="container-fluid py-4">
    <div class="row">
      <div class="col-12">
        <div class="card my-4">
          <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
            <div
              class="bg-gradient-success shadow-success border-radius-lg pt-4 pb-3"
            >
              <h6 class="text-white text-capitalize ps-3">Finger tlqkf</h6>
            </div>
          </div>
          <div class="card-body px-0 pb-2">
            <div class="button">
              <div class="mx-3">
                <button @click="messageSplit()">클릭</button>
              </div>
            </div>
            <input type="text" id="corePoolSize" v-model ="words"/>
            <table class="table table-striped">
              <tbody>
                <tr v-for="i in threadPool">
                  <!-- <td>
                    <img v-bind:src="'data:image/jpeg;base64, '+i"/>
                  </td> -->
                </tr>
              </tbody>
            </table>

          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import ThreadPoolEditCard from "./components/ThreadPoolEditCard.vue";
import MaterialInput from "@/components/MaterialInput.vue";

export default {
  name: "flows",
  data() {
    return {
      errors: [],
      modal: false,
      messageTitle: "",
      message: "",

      words: "",
      threadPool: {}
    };
  },
  mounted() {
    this.initLoad();
  },
  methods: {
    messageSplit() {
      console.log(this.threadPool);
    },
    initLoad() {
    	axios.get('/api/hello')
        .then(response => (response.data))
        .then(result => {
          // JSON responses are automatically parsed.
          this.threadPool = result;
          console.log(typeof this.threadPool);
          console.log(this.threadPool);
        })
        .catch(e => {
          this.errors.push(e)
        })
	  }
  },
  components: {
    ThreadPoolEditCard,
    MaterialInput
  },
  
};
</script>
