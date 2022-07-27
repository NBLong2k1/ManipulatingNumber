<%-- 
    Document   : Test3
    Created on : Mar 3, 2020, 8:36:02 PM
    Author     : tienpro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test 03</title>
        <style>
            *{
                font-size:25px;

            }
        </style>
    </head>
    <body>
        <form action="ControllerLesson3" method="POST">
            <table style="border:2px solid orange;margin:auto">
                <tr>
                    <td colspan='3' align='center'>
                        <b>
                            <label style="font-size:30px;font-weight:bold;color:blue">
                                INPUT AND CALCULATE
                            </label>
                        </b>
                    </td>
                </tr>
                <tr>
                    <td><br></td>
                    <td><br></td>
                </tr>
                <tr>
                    <td><i><b>Enter an integer n:</b></i></td>
                    <td rowspan='8'>
                        <textarea rows='7' cols='10'>
                       ${start} ${result}
                        </textarea>
                    </td>
                </tr>
                <tr>
                    <td><input type='text' name='n' value="${begin}" style="width:150px">
                        <input type='submit' name="submit" value='  >>  '></input></td>
                    <td></td>
                </tr>
                <tr>
                    <td><br></td>
                    <td><br></td>
                </tr>
                <tr>
                    <td align='center'>
                        <input type="submit" name="reset" value="RESET" style="font-size:20px;font-weight:bold;color:red">
                    </td>
                    <td></td>
                </tr>
                <tr>
                    <td><br></td>
                    <td><br></td>
                </tr>
                <tr>
                    <td><br></td>
                    <td><br></td>
                </tr>
                <tr>
                    <td><br></td>
                    <td><br></td>
                </tr>
                <tr>
                    <td><br></td>
                    <td><br></td>
                </tr>
                <tr>
                    <td><b>Sum of numbers in list:</b></td>

                    <td><input type='text' name="sum" value="${sum}" style="width:175px;"></input></td>
                </tr>
                <tr>
                    <td><br></td>
                    <td><br></td>
                </tr>

            </table>
        </form>
    </body>
</html>
