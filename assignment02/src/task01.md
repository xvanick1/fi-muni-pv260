# Task01 

## Statement of the testers  
Specification is buggy. It says "If  you  enter  non-empty  First  Name  and  Last  Name,  the  following  Output  is shown on the site", which mean that output should be shown without clicking on "Show output" button. We assume that we do not want solution where after each filled letter into forms, output will be actualized, most of the forms online do not work like that. So our assumption is that button for confirming the form, and requesting the output is missing in the specification.

Specification is incomplete on details about cases when one of the forms, or both of them are empty, if we asume, that both of the textBoxes should be filled up, we would run (8,9,10) tests too.  
Specification is incomplete on formats of last name and first name we want to accept.  
- *Do we want to accept numbers, signs, comas, whitespaces, etc. ? If yes, we would also need tests for these constraints.*  
- *Should every last name and last name start with Uppercase? If yes we would also need tests for these contraints.*  

Additional testing approaches to use: Whitebox testing, Graybox testing, Security testing, Usability testing, Experience-based testing.


### Test 1 

 **FAIL (Bad format - "Your name is" instead of "You are"  )**  
 **Descritption: Testing first sentence format.**  
 ***
 
 > *Input: first text Box = "Michal", second text box = "Kovac"*  
 > 
 > *Expected output: Your are Michal Kovac. You are [number] cm high.*  
 > *Actual output: Your name is Michal Kovac. You are[number] cm high.*  

### Test 2

**FAIL (Bad format - "Your are[number] cm high." instead of "You are [number] cm high."  )**  
**Descritption: Testing second sentence format.**
***

> *Input: first text Box = "Michal", second text box = "Kovac"*  
> 
> *Expected output: Your are Michal Kovac. You are [number] cm high.*  
> *Actual output: Your name is Michal Kovac. You are[number] cm high.*  

### Test 3
**FAIL (Random values out of 140-190 interval)**  
**Descritption: Testing height interval.**
***

> *Input: first text Box = "Michal", second text box = "Kovac" (click Show output few times and save the output height values)*  
> 
> *Expected output: Your are Michal Kovac. You are [140-190] cm high.*  
> *Actual output: Your name is Michal Kovac. You are[100-150] cm high.*  
> *Additional description: Most of the values fall into interval 100-150. Constant 100 in script should be changed to 140.*  

### Test 4
**FAIL (Space after Kovac is redundant)**  
**Descritption: Testing first name and last name whitespaces.**
***

> *Input: first text Box = "                 Michal               ", second text box = "            Kovac               "*  
> 
> *Expected output: Your name is Michal Kovac. You are [number] cm high.*  
> *Actual output: Your name is Michal Kovac . You are[number] cm high.*  

### Test 5
**FAIL (Space after Kovas is redundant)**  
**Descritption: Testing last name whitespaces.**
***

> *Input: first text Box = "Michal", second text box = "               Kovac               "*  
> 
> *Expected output: Your name is Michal Kovac. You are [number] cm high.*  
> *Actual output: Your name is Michal Kovac . You are[number] cm high.*  

### Test 6
**SUCCESS**  
**Descritption: Testing first name whitespaces.**
***

> *Input: first text Box = "               Michal               ", second text box = "Kovac"*  
> 
> *Expected output: Your name is Michal Kovac. You are [number] cm high.*  
> *Actual output: Your name is Michal Kovac. You are[number] cm high.*  

### Test 7

 **SUCCESS**  
 **Descritption: Testing special characters.**  
 ***
 
 > *Input: first text Box = "Michal", second text box = "Aľščťžýáíéúô"*  
 > 
 > *Expected output: ... Michal Aľščťžýáíéúô. You ...*  
 > *Actual output:   ... Michal Aľščťžýáíéúô. You ...*  
 
### TEST 8
**FAIL (Empty first text box accepted)**   
**Descritption: Testing first text box empty value.**
***

> *Input: first text Box = "", second text box = "Kovac"*  
> 
> *Expected output: Your first name is missing.*  
> *Actual output: Your name is Kovac. You are[number] cm high.*  
		       
### Test 9
**FAIL (Empty second text box accepted)**  
**Descritption: Testing second text box empty value.**
***

> *Input: first text Box = "Michal", second text box = ""*  
> 
> *Expected output: Your last name is missing*  
> *Actual output: Your name is Michal . You are[number] cm high.*  

### Test 10
**FAIL (Both empty text boxs accepted)**  
**Descritption: Testing first text box empty value and second text box empty value at once.**  
***

> *Input: first text Box = "", second text box = ""*  
> 
> *Expected output: Your first name is missing. || Your last name is missing. || Your first name and second name are missing.*  
> *Actual output: Your name is . You are[number] cm high.*  

