# Task01 

## Statement of the testers  
Specification is incomplete on details about cases when one of the forms, or both of them are empty, if we asume, that both of the textBoxes should be filled up, we would run (7,8,9) tests too.  
Specification is incomplete on formats of last name and first name we want to accept.  
- *(Do we want to accept numbers, signs, comas, whitespaces, etc. ?), if yes, we would also need tests for these constraints.*  
- *(Should every last name and last name start with Uppercase? ), if yes we would also need tests for these contraints.*  


### Test 1 
** Descritption: Testing first sentence format.**  
 **FAIL (Bad format - "Your name is" instead of "You are"  )**  
 
 ***
 
 > *Input: first text Box = "Michal", second text box = "Kovac"*  
 > 
 > *Expected output: Your are Michal Kovac. You are [140-190] cm high.*  
 > *Actual output: Your name is Michal Kovac. You are[140-190] cm high.*  

### Test 2
**FAIL (Bad format - "Your are[number] cm high." instead of "You are [number] cm high."  )**

***

> *Input: first text Box = "Michal", second text box = "Kovac"*  
> 
> *Expected output: Your are Michal Kovac. You are [number] cm high.*  
> *Actual output: Your name is Michal Kovac. You are[number] cm high.*  

### Test 3
**FAIL (Random values out of 140-190 interval)**  

***

> *Input: first text Box = "Michal", second text box = "Kovac" (click Show output few times and save the output height values)*  
> 
> *Expected output: Your are Michal Kovac. You are [140-190] cm high.*  
> *Actual output: Your name is Michal Kovac. You are[100-150] cm high.*  
> *Additional description: Most of the values fall into interval 100-150. Constant 100 in script should be changed to 140.*  

### Test 4
**FAIL**

***

> *Input: first text Box = "                 Michal               ", second text box = "            Kovac               "*  
> 
> *Expected output: Your name is Michal Kovac. You are [140-190] cm high.*  
> *Actual output: Your name is Michal Kovac . You are[140-190] cm high.*  

### Test 5
**FAIL**

***

> *Input: first text Box = "Michal", second text box = "               Kovac               "*  
> 
> *Expected output: Your name is Michal Kovac. You are [140-190] cm high.*  
> *Actual output: Your name is Michal Kovac . You are[140-190] cm high.*  

### Test 6
**SUCCESS**

***

> *Input: first text Box = "               Michal               ", second text box = "Kovac"*  
> 
> *Expected output: Your name is Michal Kovac. You are [140-190] cm high.*  
> *Actual output: Your name is Michal Kovac. You are[140-190] cm high.*  


### TEST 7
**FAIL**  

***

> *Input: first text Box = "", second text box = "Kovac"*  
> 
> *Expected output: Your first name is missing.*  
> *Actual output: Your name is Kovac. You are[140-190] cm high.*  
		       
### Test 8
**FAIL**

***

> *Input: first text Box = "Michal", second text box = ""*  
> 
> *Expected output: Your last name is missing*  
> *Actual output: Your name is Michal . You are[140-190] cm high.*  

### Test 9
**FAIL**

***

> *Input: first text Box = "", second text box = ""*  
> 
> *Expected output: Your first name is missing. || Your last name is missing. || Your first name and second name are missing.*  
> *Actual output: Your name is . You are[140-190] cm high.*  

