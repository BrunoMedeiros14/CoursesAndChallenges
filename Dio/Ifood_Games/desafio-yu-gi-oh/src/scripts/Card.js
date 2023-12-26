class Card {
  constructor(name, type, description) {
    this.name = name;
    this.type = type;
    this.description = description;
  }

  executeDuel = card => {
    const winMap = {
      rock: 'scissors',
      paper: 'rock',
      scissors: 'paper',
    };
    return this.type === card.getType()
      ? 'Empate'
      : winMap[this.type] === card.getType()
      ? 'Ganhou'
      : 'Perdeu';
  };

  getName = _ => this.name;
  getType = _ => this.type;
  getDescription = _ => this.description;
}

export default Card;
