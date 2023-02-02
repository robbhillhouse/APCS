import numpy as np
import csv

with open("/Users/23hillhouse/Downloads/archive/trumptweets.csv") as file:
  corpus = file.read()

def build_transition_matrix(corpus):
    corpus = corpus.split(" ")
    transitions = {} #creates matrix
    for k in range(0, len(corpus)):
        word = corpus[k]
        if k != len(corpus) - 1:  # Deal with last word
            next_word = corpus[k + 1]
        else:
            next_word = corpus[0]  # To loop back to the beginning

        if word not in transitions:
            transitions[word] = []

        transitions[word].append(next_word)
    return transitions

def sample_sentence(corpus, sentence_length, burn_in=1000):
    sentence = []

    transitions = build_transition_matrix(corpus)
    # sample the sentence after running through the chain 1000 times to near a stationary distribution.
    current_word = np.random.choice(corpus.split(' '), size=1)[0]
    for k in range(0, burn_in + sentence_length):
        # Sample from the lists with an equal chance for each entry
        # This chooses a word with the correct probability distribution in the transition matrix
        current_word = np.random.choice(transitions[current_word], size=1)[0]

        if k >= burn_in:
            sentence.append(current_word)

    return ' '.join(sentence)


print(sample_sentence(corpus, 20, 1000))