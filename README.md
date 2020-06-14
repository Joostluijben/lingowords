[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=Joostluijben_lingowords&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=Joostluijben_lingowords)
[![codecov](https://codecov.io/gh/Joostluijben/lingowords/branch/master/graph/badge.svg)](https://codecov.io/gh/Joostluijben/lingowords)
[![Build Status](https://dev.azure.com/joostluijben/lingo/_apis/build/status/Joostluijben.lingowords?branchName=master)](https://dev.azure.com/joostluijben/lingo/_build/latest?definitionId=10&branchName=master)

The words are loaded from a file and put into memory<br>
They are available from an api 

Get all the valid words: https://joostluijben-lingowords.herokuapp.com/words

Get a random word: https://joostluijben-lingowords.herokuapp.com/words/randomWord

Give the path parameter wordLength for the length of a word<br>
https://joostluijben-lingowords.herokuapp.com/words/randomWord?wordLength=5 <br>
https://joostluijben-lingowords.herokuapp.com/words?wordLength=5

The wordLength can be 5, 6 or 7
