/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*Write a program that outputs the string representation of numbers from 1 to n.

 But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

 Example:

  n = 15,

 Return:
  [
      "1",
        "2",
        "Fizz",
        "4",
        "Buzz",
        "Fizz",
        "7",
        "8",
        "Fizz",
        "Buzz",
        "11",
        "Fizz",
        "13",
        "14",
        "FizzBuzz"
        ]*/


 
* 
* 思想：

* (1) 首先把 1-n个数的信息保存后，类似于BCD编码一样，减少取余操作带来的效率损失

----
    
    public List<String> fizzBuzz(int n) {

        int[] type = new int[n + 1];
        for (int i = 3; i <= n; i += 3) {
            type[i] += 1;
        }
        for (int i = 5; i <= n; i += 5) {
            type[i] += 2;
        }

        List<String> result = new ArrayList<String>(n);
        for (int i = 1; i <= n; i++) {
            if (type[i] == 3) {
                result.add("FizzBuzz");
            } else if (type[i] == 2) {
                result.add("Buzz");
            } else if (type[i] == 1) {
                result.add("Fizz");
            } else {
                result.add(Integer.toString(i));
            }
        }

        return result;
    }
