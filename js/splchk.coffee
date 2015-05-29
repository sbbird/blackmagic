Array::unique = ->
  output = {}
  output[@[key]] = @[key] for key in [0...@length]
  value for key, value of output

class SplChk

  @trie = {}
  @END = '$'
  constructor: (@dict) ->
    @trie = @build_trie @dict

  build_trie: (dict) ->
    trie = {}
    for word in dict
      t = trie
      for c in word
        t[c] = {} if c not of t
        t = t[c]
      t[@END] = {}
    return trie

  check_fuzzy: (trie, word, path, tol) ->
    return [] if tol < 0
    if word == ''
      if @END of trie then return [path] else return []
    res = []
    ch = word[0]
    for key of trie
      toln = if key == ch then tol else tol - 1                                     # edit distance +1 if the character not matches
      res = res.concat @check_fuzzy(trie[key], word.substring(1), path + key, toln) 
      res = res.concat @check_fuzzy(trie[key], word, path + key, toln)              # edit distance +1 if an character omitted
    res = res.concat @check_fuzzy(trie, word.substring(1), path, tol - 1)           # edit distance +1 if an extra character added
    return res

  check: (word) ->
    res =  @check_fuzzy @trie, word, '', 1
    return res.unique()

module.exports = SplChk

#dict = ['hello', 'how', 'are', 'you']
#splchk = new SplChk dict
#console.log JSON.stringify splchk.check 'hellu'
