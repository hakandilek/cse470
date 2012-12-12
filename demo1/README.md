demo1 - a simple floating point calculator
======
 - using JUnit library
   licensed under [CPL](https://github.com/KentBeck/junit/blob/master/LICENSE)
   
 - setUp method for preparing test case
 - tearDown method for cleaning up threads/objects
 - tests are unordered
 - CalculatorTest 
 <table>
  <tr>
    <td> &darr; </td>
    <td> &darr; </td>
    <td> &darr; </td>
    <td> &darr; </td>
  </tr>
  <tr>
    <td>setUp()</td>
    <td>setUp()</td>
    <td>setUp()</td>
    <td>setUp()</td>
  </tr>
  <tr>
    <td>testAdd()</td>
    <td>testSubract()</td>
    <td>tearMultiply()</td>
    <td>tearDivide()</td>
  </tr>
  <tr>
    <td>tearDown()</td>
    <td>tearDown()</td>
    <td>tearDown()</td>
    <td>tearDown()</td>
  </tr>
  <tr>
    <td> &bull; </td>
    <td> &bull; </td>
    <td> &bull; </td>
    <td> &bull; </td>
  </tr>
</table>