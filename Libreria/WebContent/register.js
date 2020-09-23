function insert()
{
	var isbn, author, category, title;
	isbn = document.getElementById("isbn").value;
	author = document.getElementById("author").value;
	category = document.getElementById("category").value;
	title = document.getElementById("title").value;
	
	if (isbn != null && author != null && category != null && title !=null)
	{
		try {
			if (parseInt(isbn) && parseInt(author) && parseInt(category))
			{
				document.forms[0].action ="showBooks.do";
				document.forms[0].submit();
			}
		} catch (error) {
			alert("Los campos de: isbn, author y categoria deben de ser enteros y title debe de ser String.");
		}
	}
}