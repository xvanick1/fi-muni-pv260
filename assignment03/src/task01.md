# Task01

## 1. Problem
Your acceptance tests run 20 hours in CI. You cannot use CI for verification of emergency fixes as it takes too long to get relevant results from it. That means sometimes emergency fixes are released uncomfortably late (waiting for tests to be executed), sometimes not prop- erly tested.

### 1. possible root cause

Inappropriately selected batch of tests. Don't need to test parts of the system which do not relate to the fix.
- possible bug won't appear in the tests, batch of tests does not cover all the parts of the system which emergency fix applies to.
- some tests may be depended on/connected to more parts of the system (ex. setup method), so we have to rewrite/refactor them as we don't want them to be depended on the other parts of the system but want to use them in the batch of tests. This may lead to a new bug. This is a bad approach to the problem. We should not tailor/adapt tests to the code, but vice-versa.

### 2. possible root cause
Bad architecture of the whole project and/or tests. Inefficient code - improper use of memory, break of SOLID, etc.

### 3. possible root cause
Bottleneck in the CI. The tests and the system run fine, except of one place where a problem slows down whole system.

### 1. reasonable solution
We could test only the system module which the fix relates to. Refactor batch of tests/better selection of the tests to the batch.

### 2. reasonable solution
Refactor of the whole project architecture.

### 3. reasonable solution
Block the part of the system (which emergency fix applies to) until the tests are completed.

### 4. reasonable solution
Use of multiple CIs (backup server where the system will run until the emergency fix is tested and applied)

### 5. reasonable solution
Make the tests run faster (better SW/HW or cloud - parallel processing)

## 2. Problem
Other teams (the same teams over and over again) often break your tests in CI in master and future-release branches. Most of those test failures catch real problems. You spend a lot of time on failing test investigation and teams must often solve problems not long before the release.

### 1. possible root cause
Incorrectly designed/used tests in the team that is causing the problems. Insufficient test coverage of the system in that team.

### 2. possible root cause
The problem-causing team uses different platform (than we do) on which CI for testing runs. Bugs are only discovered during testing by our team using a different platform than the other team.

### 3. possible root cause
Poorly designed interface between project modules.

### 1. reasonable solution
Audit of tests in the "problematic" team with the subsequent recommendations to fix the cause of the problem.

### 2. reasonable solution
Extension of testing environments for individual teams (multiplatform).

### 3. reasonable solution
Redesign of the interface between project modules.
- chance of creating new bugs in the implementation
- need of big and complicated modification (not just in the interface). This is costly, more work has to be done and also, there's a need for more testers.

## 3. Problem
Customers often find out really serious security bugs affecting them, representing a threat to them. Some of the customers share that bug with public / actively write about it to other of your customers.

### 1. possible root cause
Contract does not contain a non-disclosure agreement that prevents the customer from spreading information about security risks and at the same time forces him to report it to us.

### 2. possible root cause
Poorly testing and analysis of product security which leads to the detection of these errors by customers and not our testers.

### 3. possible root cause
Code exposure/leaks, which leads to simpler finding of bugs in code. 

### 4. possible root cause
Insufficient motivation of customers to report errors to the supplier.

### 1. reasonable solution  
Modification of the contract, anchoring of the confidentiality agreement about the security risks into the contract.
- Overpriced product - a necessary proposal and legal analysis of the part of the contract, a more complicated relationship with the customer.
- Inappropriate / strictly designed confidentiality agreement, which will discourage customers from using our product / hole in the confidentiality agreement, which will still allow some leak of information.

### 2. reasonable solution
Rewarding our customers for finding security risks in the form of discounts on the products.

### 3. reasonable solution
Improving our process of finding security bugs and risks.

