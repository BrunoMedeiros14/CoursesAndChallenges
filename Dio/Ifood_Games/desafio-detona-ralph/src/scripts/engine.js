const state = {
  view: {
    gameBoard: document.querySelector('#gameBoard'),
    squares: document.querySelectorAll('.ralphBox'),
    ralph: document.querySelector('.ralph'),
    timeLeft: document.querySelector('#timeLeft'),
    score: document.querySelector('#playerScore'),
    playerLifes: document.querySelector('#playerLifes'),
  },
  values: {
    gameVelocity: 1000,
    hitPosition: 0,
    result: 0,
    curretTime: 60,
    lifes: 3,
  },
  actions: {
    timerId: setInterval(randomSquare, 1000),
    countDownTimerId: setInterval(countDown, 1000),
  },
};

function countDown() {
  state.values.curretTime--;
  state.view.timeLeft.textContent = state.values.curretTime;

  if (state.values.curretTime <= 0) {
    clearInterval(state.actions.countDownTimerId);
    clearInterval(state.actions.timerId);
    alert('Game Over! O seu resultado foi: ' + state.values.result);
  }
}

function playSound(audioName) {
  let audio = new Audio(`./src/audios/${audioName}.m4a`);
  audio.volume = 0.2;
  audio.play();
}

function randomSquare() {
  state.view.squares.forEach(square => {
    square.classList.remove('ralph');
  });

  let randomNumber = Math.floor(Math.random() * 9);
  let randomSquare = state.view.squares[randomNumber];
  randomSquare.classList.add('ralph');
  state.values.hitPosition = randomSquare.id;
}

function addListenerHitBox() {
  state.view.gameBoard.addEventListener('mousedown', square => {
    if (square.target.id === state.values.hitPosition) {
      state.values.result++;
      state.view.score.textContent = state.values.result;
      state.values.hitPosition = null;
      playSound('hit');
      countDown();
    } else {
      state.values.lifes--;
      state.view.playerLifes.textContent = state.values.lifes;
    }
  });
}

function initialize() {
  addListenerHitBox();
}

initialize();
