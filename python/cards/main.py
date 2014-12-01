from deck import Deck

if __name__ == "__main__":
    myDeck = Deck()
    print "Top card %s" % myDeck.peekTopCard().toString()
    myDeck.shuffle()
    print "Top card %s" % myDeck.peekTopCard().toString()
    print "Deck size %d" % myDeck.getSize() 
    print "Number of cards in correct place %d" % myDeck.getShuffledValue()
