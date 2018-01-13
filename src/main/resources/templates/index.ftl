<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>天才的牛B之路</title>

    <style type="text/css">
        body{ margin: 0; padding: 0; font: 12px normal Verdana, Arial, Helvetica, sans-serif; height: 100%; background-color: #000000; }
        *{margin:0;padding:0;outline:none;}
        img{border:none;}
        a{text-decoration:none;color:#00c6ff;}
        .container{width:960px;margin:0 auto;overflow:hidden;}

        /* 演示二 */
        #content{
            position: absolute;
            top: 50%;
            width:100%;
            height:5px;
            margin:50px auto;
            background:#000;
        }

        .fullwidth .expand{
            width:100%;
            height:1px;
            margin:2px 0;
            background:#2187e7;
            position:absolute;
            box-shadow:0px 0px 10px 1px rgba(0,198,255,0.7);
            -moz-animation:fullexpand 10s ease-out;
            -webkit-animation:fullexpand 10s ease-out;
        }

        @-moz-keyframes fullexpand{
            0%{width:0px;}
            100%{ width:100%;}
        }
        @-webkit-keyframes fullexpand{
            0%{width:0px;}
            100%{ width:100%;}
        }

        /* 触发按钮 */
        .trigger, .triggerFull, .triggerBar{
            background:#000000;
            background:-moz-linear-gradient(top, #161616 0%, #000000 100%);
            background:-webkit-linear-gradient(top, #161616 0%,#000000 100%);
            border-left:1px solid #111;border-top:1px solid #111;border-right:1px solid #333;border-bottom:1px solid #333;
            font-family:Verdana, Geneva, sans-serif;
            font-size:14px;
            text-decoration:none;
            text-transform:lowercase;
            text-align:center;
            color:#fff;
            padding:10px;
            border-radius:3px;
            display:block;
            margin:0 auto;
            width:140px;
        }

        .trigger:hover, .triggerFull:hover, .triggerBar:hover{
            background:-moz-linear-gradient(top, #202020 0%, #161616 100%);
            background:-webkit-linear-gradient(top, #202020 0%, #161616 100%);
        }
    </style>

    <script src="/other/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $('#content').removeClass('fullwidth').delay(10).queue(function(next){
                $(this).addClass('fullwidth');
                next();
            });
            setTimeout(function () {
                window.open("myConsole/${(user.userId)!}.html?sessionId=${sessionId!}","_self");
            },5000)
        });

    </script>

</head>
<body>
<input type="hidden" name="sessionId" value="${sessionId!}"/>
<div id="content">
    <span class="expand"></span>
</div>

</body>
</html>