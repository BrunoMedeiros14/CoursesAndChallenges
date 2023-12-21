const reset = document.querySelector('#reset');
const table = document.querySelector('.game');
const emojis = ['🐱', '🦝', '🦊', '🐶', '🐵', '🦁', '🐯', '🐮'];
let openCards = [];

const checkMatch = _ => {
  if (openCards[0].innerHTML === openCards[1].innerHTML) {
    openCards[0].classList.add('boxMatch');
    openCards[1].classList.add('boxMatch');
  } else {
    openCards[0].classList.remove('boxOpen');
    openCards[1].classList.remove('boxOpen');
  }

  openCards = [];

  if (document.querySelectorAll('.boxMatch').length === emojis.length) {
    alert('Você venceu !');
  }
};

const handleClick = target => {
  if (openCards.length < 2) {
    target.classList.add('boxOpen');
    openCards.push(target);
  }

  if (openCards.length == 2) {
    setTimeout(checkMatch, 500);
  }

  console.log(openCards);
};

const criarDiv = e => {
  const box = document.createElement('div');
  box.className = 'item';
  box.innerHTML = e;
  document.querySelector('.game').appendChild(box);
};

const writeHtml = emojis =>
  emojis
    .flatMap(e => [e, e])
    .sort(() => (Math.random() > 0.5 ? 2 : -1))
    .forEach(criarDiv);

const initialize = _ => {
  table.addEventListener('click', ({ target }) => {
    handleClick(target);
  });
  writeHtml(emojis);
};

reset.addEventListener('click', () => {
  window.location.reload();
});

initialize();
