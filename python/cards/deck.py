from card import Card
import random

class Deck:
    
    def __init__(self):
        self.deck = []
        for suit in range(4):
            for value in range(1, 14):
                self.deck.append(Card(suit, value))        

    def getSize(self):
        return len(self.deck)

    def peekTopCard(self):
        if (len(self.deck) > 0):
            return self.deck[0] 

    def removeTopCard(self):
        if (len(self.deck) > 0):
            return self.deck.pop(0)

    def shuffle(self):
	for i in range(5000):
	    firstRandom = random.randrange(52);
	    secondRandom = random.randrange(52);

	    firstRandomCard = self.deck[firstRandom]
	    self.deck[firstRandom] = self.deck[secondRandom]
	    self.deck[secondRandom] = firstRandomCard

    def getShuffledValue(self):
        inPlaceCount = 0;
        x = 1;        
        for card in self.deck:
	    if card.value + 13 * card.suit == x:
                inPlaceCount += 1;
            x += 1    
        return inPlaceCount;
            #diamond, 13 in spot ~13, club, 13 in spot 26, heart 13 in spot 39
