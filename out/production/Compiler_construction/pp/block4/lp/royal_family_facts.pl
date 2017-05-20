mother(emma,wilhelmina).
mother(wilhelmina,juliana).
mother(juliana,beatrix).
mother(juliana,margriet).
mother(juliana,irene).
mother(juliana,christina).
mother(margriet,maurits).
mother(margriet,bernhard_jr).
mother(margriet,pieter_christiaan).
mother(margriet,floris).
mother(beatrix,alexander).
mother(beatrix,friso).
mother(beatrix,constantijn).
mother(maxima,amalia).
mother(maxima,alexia).
mother(maxima,ariane).

husband(bernhard,juliana).
husband(claus,beatrix).
husband(pieter,margriet).
husband(alexander,maxima).
husband(friso,mabel).
husband(constantijn,laurentien).

female(irene).
female(christina).
female(amalia).
female(alexia).
female(ariane).
female(X) :- mother(X,_).
female(X) :- husband(_,X).

male(maurits).
male(bernhard_jr).
male(pieter_christiaan).
male(floris).
male(X) :- husband(X,_).
