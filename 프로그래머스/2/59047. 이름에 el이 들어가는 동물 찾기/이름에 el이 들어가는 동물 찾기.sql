-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE (NAME LIKE '%el%' 
       OR NAME LIKE '%El%' 
       OR NAME LIKE '%eL%' 
       OR NAME LIKE '%EL%')
       AND ANIMAL_TYPE = 'Dog'
ORDER BY NAME; 