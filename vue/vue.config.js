const { defineConfig } = require('@vue/cli-service')
module.exports = {
  transpileDependencies: [ "@splidejs" ],
  outputDir: 'target/dist',
  assetsDir: 'static',
  lintOnSave: false,
  devServer: {
    port: 3000,
    historyApiFallback: true,
    proxy: {
      "/api": {
        target: "http://localhost:4567",
        ws: true,
        changeOrigin: true,
        pathRewrite: {
          "^/api": "",
        },
      },
    },
  },
}
