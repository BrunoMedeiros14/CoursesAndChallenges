import Card from './Card.js';

const engine = {
  view: {
    scoreDisplay: document.querySelector('.score_container'),
    playerCardVersus: document.querySelector('.card-versus_container.player'),
    enemyCardVersus: document.querySelector('.card-versus_container.enemy'),
    buttonReplayContainer: document.querySelector('.replay-button_container'),
  },
  player: {
    cardImage: document.querySelector('.show-card_container'),
    cardInfo: document.querySelector('.info-card_container'),
    cardsContainer: document.querySelector('.cards_container.player'),
    win: 0,
    cards: new Map(),
  },
  enemy: {
    cardsContainer: document.querySelector('.cards_container.enemy'),
    win: 0,
    cards: new Map(),
  },
};
document.querySelector('#bg-audio').volume = 0.3;

const getRandomCard = cards => {
  return cards[Math.floor(Math.random() * cards.length)];
};

const playBackgroundAudio = _ => {
  const audio = new Audio(`./src/assets/audios/egyptian_duel.wav`);
  audio.volume = 0.3;
  audio.play();
};

const playAudio = async result => {
  const audioName = result === 'Perdeu' ? 'lose' : 'win';
  const audio = new Audio(`./src/assets/audios/${audioName}.wav`);
  audio.volume = 1;
  await audio.play();
};

const getMpCards = _ => {
  const mpCards = new Map();

  const cards = [
    new Card('dragon', 'paper', 'Blue Eyes White Dragon'),
    new Card('exodia', 'scissors', 'The master of Deck'),
    new Card('magician', 'rock', 'The magician'),
  ];

  for (let i = 0; i < 5; i++) {
    mpCards.set(i.toString(), getRandomCard(cards));
  }

  return mpCards;
};

const resetGameValues = _ => {
  const { cardImage, cardInfo } = engine.player;
  const { cardDescription, cardAttribute } = cardInfo.children;
  cardImage.children[0].src = './src/assets/icons/card-back.png';
  cardDescription.innerText = 'Selecione';
  cardAttribute.innerText = 'Uma Carta';

  engine.view.buttonReplayContainer.children[0].remove();
  const { playerCardVersus, enemyCardVersus } = engine.view;
  const blankVersusDiv = document.createElement('div');
  blankVersusDiv.classList.add('no-card');
  playerCardVersus.children[0].remove();
  playerCardVersus.appendChild(blankVersusDiv.cloneNode());
  enemyCardVersus.children[0].remove();
  enemyCardVersus.appendChild(blankVersusDiv);
};

const createImgDiv = imgId => {
  const imgDiv = document.createElement('img');
  imgDiv.src = './src/assets/icons/card-back.png';
  imgDiv.alt = `img ${imgId}`;
  imgDiv.ariaLabel = imgId;
  return imgDiv;
};

const createVersusImgDiv = cardName => {
  const imgDiv = document.createElement('img');
  imgDiv.src = `./src/assets/icons/${cardName}.png`;
  imgDiv.alt = `img ${cardName}`;
  return imgDiv;
};

const createReplayButton = result => {
  const btnDiv = document.createElement('button');
  btnDiv.classList.add('rpgui-button', 'btn');
  btnDiv.textContent = result;
  btnDiv.type = 'button';
  return btnDiv;
};

const writeCardsOnHtml = div => {
  Array.from(engine.enemy.cards).map(([key, _]) =>
    div.appendChild(createImgDiv(key))
  );
};

const writePlayerCardData = cardId => {
  const card = engine.player.cards.get(cardId);
  const { cardImage, cardInfo } = engine.player;
  const { cardDescription, cardAttribute } = cardInfo.children;
  cardImage.children[0].src = `./src/assets/icons/${card.getName()}.png`;
  cardDescription.innerText = card.getDescription();
  cardAttribute.innerText = `Attribute: ${card.getType()}`;
};

const cleanDeckToFight = _ => {
  engine.enemy.cardsContainer.innerHTML = '';
  engine.player.cardsContainer.innerHTML = '';
};

const getRandomEnemyCard = _ => {
  const enemyCardNumber = Math.floor(
    Math.random() * (engine.enemy.cards.size - 1)
  ).toString();
  return engine.enemy.cards.get(enemyCardNumber);
};

const updateScoreDisplay = _ => {
  const { player, enemy } = engine;
  const playerScore = player.win;
  const enemyScore = enemy.win;
  engine.view.scoreDisplay.textContent = `Win: ${playerScore} | Lose: ${enemyScore}`;
};

const startBattle = playerCardId => {
  const card = engine.player.cards.get(playerCardId);
  const enemyCard = getRandomEnemyCard();
  cleanDeckToFight();
  const { playerCardVersus, enemyCardVersus } = engine.view;
  playerCardVersus.children[0].remove();
  playerCardVersus.appendChild(createVersusImgDiv(card.getName()));
  enemyCardVersus.children[0].remove();
  enemyCardVersus.appendChild(createVersusImgDiv(enemyCard.getName()));
  const result = card.executeDuel(enemyCard);
  const victorious = result === 'Ganhou' ? 'player' : 'enemy';
  if (result !== 'Empate') engine[victorious].win++;
  engine.view.buttonReplayContainer.appendChild(createReplayButton(result));
  playAudio(result);
};

const initialize = () => {
  engine.enemy.cards = getMpCards();
  writeCardsOnHtml(engine.enemy.cardsContainer);

  engine.player.cards = getMpCards();
  writeCardsOnHtml(engine.player.cardsContainer);
};

engine.player.cardsContainer.addEventListener('mouseover', e => {
  const cardId = e.target.ariaLabel;
  if (cardId) writePlayerCardData(cardId);
});

engine.player.cardsContainer.addEventListener('click', e => {
  const cardId = e.target.ariaLabel;
  if (cardId) startBattle(cardId);
});

engine.view.buttonReplayContainer.addEventListener('click', e => {
  updateScoreDisplay();
  resetGameValues();
  initialize();
});

initialize();
playBackgroundAudio();
