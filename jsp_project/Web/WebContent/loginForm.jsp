<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>로그인 Form</title>
        <meta charset="utf-8">
        
        <style>
        
            body, div, h1, form {
                margin:0;
                padding:0;
            }
            
            h1 {
                margin: 15px;
            }
            
            #form {
                margin : 10px auto;
            }
            
            td {
                padding : 10px;
            }
            
            #btn_submit{
                padding : 10px;
                background-color: aquamarine;
                font-weight: bold;
                color: darkgreen;
                border : 1px solid #EEEEEE;
            }
            
            
        </style>

    </head>
    <body>
        <h1>회원 로그인</h1>
        <hr>
        <form action="main.jsp" method="get" id="loginForm">
        <table id="form">
            <tr>
                <td>아이디(이메일)</td>
                <td><input type="text" name="id" id="id"></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" name="pw" id="pw"></td>
            </tr>
            <tr>
                <td></td>
                <td><input id="btn_submit" type="submit" value="로그인"></td>
            </tr>
        </table>
        </form>
        
        
        
    </body>
    <script src="../js/logincheck.js"></script>

</html>