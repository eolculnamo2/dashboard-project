const path = require('path')

module.exports = {
  entry: './src/main.js',
  output: {
    path: path.resolve('./build'),
    filename: 'bundle.js'
  },
  devServer: {
    contentBase: path.join(__dirname, 'public'),
    port: 3000,
    publicPath: '/',
    proxy: {
      '/': 'http://127.0.0.1:8080/'
    }
  },
  module: {
    rules: [
      {
        test: /\.js$/,
        exclude: /(node_modules)/,
        loader: 'babel-loader',
        query: {
          presets: ['@babel/preset-env']
        }
      },
      {
        test: /\.vue$/,
        loader: 'vue-loader'
      },
      {
        test: /\.(png|jpg|gif)$/,
        loader: 'url-loader'
        
      },
      { 
        test: /\.svg$/, 
        loader: 'raw-loader' 
      }, 
      {
        test: /\.(s*)css$/,
        use: ["style-loader","css-loader","sass-loader"]
      }
    ]
  }
}
