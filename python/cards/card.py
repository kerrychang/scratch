class Card:

    def __init__(self, suit, value):
	if suit < 0 or suit > 3:
	    raise RuntimeError("Suit must be of value [0-3]")        
        if value < 1 or value > 13:
            raise RuntimeError("Value must be of value [1-13]")

	self.suit = suit
        self.value = value

    def getSuit(self):
        return self.suit

    def getValue(self):
        return self.value
        
    def toString(self):
        if self.suit == 0:
            suitName = "Diamond"
        elif self.suit == 1:
            suitName = "Club"
        elif self.suit == 2:
            suitName = "Heart"
        else:
            suitName = "Spade"
        
        return "[Suit: %s, Value: %d]" % (suitName, self.value)
