import java.util.Arrays;

public class TaskFourUpword{

public static int[] taskFour(int[] arrays){

int increment = 0;

for(int count = 0; count < arrays.length; count++){
if(count % 2 == 0){
increment++;
 } 
}

int[] result = new int[increment];
int incrementTwo = 0;

for(int counter = 0; counter < arrays.length; counter++){
if(counter % 2 == 0){
result[incrementTwo] = arrays[counter];
incrementTwo++;
 } 
}
return result;
}



public static int[] taskFive(int[] arrays){

int increment = 0;

for(int count = 0; count < arrays.length; count++){
if(count % 2 != 0){
increment++;
 } 
}

int[] result = new int[increment];
int incrementTwo = 0;

for(int counter = 0; counter < arrays.length; counter++){
if(counter % 2 != 0){
result[incrementTwo] = arrays[counter];
incrementTwo++;
 } 
}
return result;
}



public static int taskSix(int[] arrays){

int increment = 0;

for(int count = 0; count < arrays.length; count++){
if(count % 2 == 0){
increment++;
 } 
}

int[] result = new int[increment];
int incrementTwo = 0;
int sum = 0;

for(int counter = 0; counter < arrays.length; counter++){
if(counter % 2 == 0){
result[incrementTwo] = arrays[counter];
sum += result[incrementTwo] ;
incrementTwo++;
 } 
}
return sum;
}


public static int taskSeven(int[] arrays){

int increment = 0;

for(int count = 0; count < arrays.length; count++){
if(count % 2 != 0){
increment++;
 } 
}

int[] result = new int[increment];
int incrementTwo = 0;
int sum = 0;

for(int counter = 0; counter < arrays.length; counter++){
if(counter % 2 != 0){
result[incrementTwo] = arrays[counter];
sum += result[incrementTwo] ;
incrementTwo++;
 } 
}
return sum;
}



public static int taskEight(int[] arrays){

int increment = 0;

for(int count = 0; count < arrays.length; count++){
if(count % 2 == 0){
increment++;
 } 
}

int[] result = new int[increment];
int incrementTwo = 0;
int min = Integer.MAX_VALUE;

for(int counter = 0; counter < arrays.length; counter++){
if(counter % 2 == 0){
result[incrementTwo] = arrays[counter];

if(result[incrementTwo] < min){
 min = result[incrementTwo];
}
incrementTwo++;
 } 
}
return min;
}



public static int taskNine(int[] arrays){

int increment = 0;

for(int count = 0; count < arrays.length; count++){
if(count % 2 != 0){
increment++;
 } 
}

int[] result = new int[increment];
int incrementTwo = 0;
int min = Integer.MAX_VALUE;

for(int counter = 0; counter < arrays.length; counter++){
if(counter % 2 != 0){
result[incrementTwo] = arrays[counter];

if(result[incrementTwo] < min){
 min = result[incrementTwo];
}
incrementTwo++;
 } 
}
return min;
}


public static int taskTen(int[] arrays){

int increment = 0;

for(int count = 0; count < arrays.length; count++){
if(count % 2 == 0){
increment++;
 } 
}

int[] result = new int[increment];
int incrementTwo = 0;
int max = Integer.MIN_VALUE;

for(int counter = 0; counter < arrays.length; counter++){
if(counter % 2 == 0){
result[incrementTwo] = arrays[counter];

if(result[incrementTwo] > max){
 max = result[incrementTwo];
}
incrementTwo++;
 } 
}
return max;
}



public static int taskEleven(int[] arrays){

int increment = 0;

for(int count = 0; count < arrays.length; count++){
if(count % 2 != 0){
increment++;
 } 
}

int[] result = new int[increment];
int incrementTwo = 0;
int max = Integer.MIN_VALUE;

for(int counter = 0; counter < arrays.length; counter++){
if(counter % 2 != 0){
result[incrementTwo] = arrays[counter];

if(result[incrementTwo] > max){
 max = result[incrementTwo];
}
incrementTwo++;
 } 
}
return max;
}




public static int[] taskTwelve(int[] arrays) {

for (int count = 0; count < arrays.length - 1; count += 2) {

int temp = arrays[count];

arrays[count] = arrays[count + 1];

arrays[count + 1] = temp;
 }
return arrays;
}



public static int[] taskThirteen(int[] arrays) {

boolean evenElement = false;

for(int element : arrays){
if(element % 2 == 0){
 evenElement = true;
 break;
 }
}

if(!evenElement){
for (int count = 0; count < arrays.length - 1; count += 2) {

int temp = arrays[count];

arrays[count] = arrays[count + 1];

arrays[count + 1] = temp;
 }
}
return arrays;
}


public static int[] taskFourteen(int[] arrays) {

boolean oddElement = false;

for(int element : arrays){
if(element % 2 != 0){
 oddElement = true;
 break;
 }
}

if(!oddElement){

for (int count = 0; count < arrays.length - 1; count += 2) {

int temp = arrays[count];

arrays[count] = arrays[count + 1];

arrays[count + 1] = temp;
 }
}
return arrays;
}




public static void main(String[] args){

int[] arrays = {4,9,2,8,3,5,6,7,11};
int[] arraysTwo = {2,4,6,8,10};

System.out.println("Elements on even index: " + Arrays.toString(taskFour(arrays)));

System.out.println("Elements on odd index: " + Arrays.toString(taskFive(arrays)));

System.out.println("Sum of elements on even index: " + taskSix(arrays));

System.out.println("Sum of elements on odd index: " + taskSeven(arrays));

System.out.println("Minimum of elements on even index: " + taskEight(arrays));

System.out.println("Minimum of elements on odd index: " + taskNine(arrays));

System.out.println("Maximum of elements on even index: " + taskTen(arrays));

System.out.println("Maximum of elements on odd index: " + taskEleven(arrays));

System.out.println("Swap even indexes: " + Arrays.toString(taskTwelve(arrays)));

System.out.println("Don't swap if any of the elements is even: " + Arrays.toString(taskThirteen(arraysTwo)));

System.out.println("Don't swap if any of the elements is odd: " + Arrays.toString(taskFourteen(arraysTwo)));

 }
}