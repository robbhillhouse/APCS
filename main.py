import markovify #python library that is made for markov chains

with open("/Users/23hillhouse/Downloads/archive/trumptweets.csv") as f:
    text = f.read()
    text_model = markovify.Text(text)

for i in range(1):
    print(text_model.make_sentence())
