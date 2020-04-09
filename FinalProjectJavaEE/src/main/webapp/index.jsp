<html>
    <body>
        <h2>Hello World index!</h2>
        <p>
            <%
                java.util.Date now = new java.util.Date();
                String somestring = "Date now - " + now;
                for (int i = 0; i<10; i++){
                    out.print("<p> String N = " + i+"</p>");
                }
            %>
            <p>
            <%=  somestring %>
        <br/>

        <a href="servlet">Click here to see servlet</a>
    </body>
</html>
