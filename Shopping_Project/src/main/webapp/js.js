console.clear();

const $loading = document.querySelector('.c-loading');
const $text = document.querySelector('.c-loading__text');
const $progress = document.querySelector('.c-loading__progress');

// 資料庫
// number
let percent = 0;

function init() {
  console.log(percent);
  percent++
  // 更新畫面
  // 不使用 ES6 字串模板寫法
  // $text.textContent = '網頁載入進度：' + p dercent + '%'
  $text.textContent = `網頁載入進度：${percent}%`
  $progress.style.width = percent + '%'
  
  // 三個等號比較嚴謹，不同 type 不會成立
  // if (percent === '100') // string 不成立
  if (percent === 100) {
    clearInterval(loadingTimer)
    $loading.classList.add('has-loaded');
    setTimeout(function() {
      document.querySelector('h1').textContent = 'Hello World!!!'
    }, 1200)
  }
};
// init 不給括號，因為 setInterval 會幫他執行
const loadingTimer = setInterval(init, 50);

// setTimeout(function() {
//   console.log('!!!!');
// }, 5000);

// let num = 0;
// const timer = setInterval(function() {
//   num++;
//   document.querySelector('h2').textContent = num;
// }, 1000);

// setTimeout(function() {
//   clearInterval(timer);
// }, 8000);