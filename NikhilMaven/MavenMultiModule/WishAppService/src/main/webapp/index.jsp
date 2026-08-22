<%@ page import = 'in.razorpay.nikhil.main.*'%>
<h1 style='color: green'>
Generating the wish massage for the the user::
<%= new WishMassageService().wishUser("sheerpal") %>
</h1>