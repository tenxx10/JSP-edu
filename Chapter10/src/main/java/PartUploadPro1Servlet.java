
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
/**
 * Servlet implementation class PartUploadPro1Servlet
 */
@WebServlet("/PartUploadPro1Servlet")
@MultipartConfig(
		fileSizeThreshold=0,
		location = "C:/jsp2.3/upload"
		)
public class PartUploadPro1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	


    /**
     * @see HttpServlet#HttpServlet()
     */
    public PartUploadPro1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String writer = request.getParameter("writer");
		Part part = request.getPart("partFile1");
		response.setContentType("text/html; charset= utf-8");
		PrintWriter out = response.getWriter();
		String contentDisposition = part.getHeader("content-disposition");
		String uploadFileName = getUploadFileName(contentDisposition);
		part.write(uploadFileName);
		out.println("작성자" + writer+"님이"+uploadFileName+"파일을 업로드하였습니다.");
		
	}

	// 사용 브라우저가 ie인 경우
//	private String getUploadFileName(String contentDisposition) {
//		// TODO Auto-generated method stub
//		String uploadFileName = null;
//		String[] contentSplitStr = contentDisposition.split(";");
//		int lastPathSeparatorIndex = contentSplitStr[2].lastIndexOf("\\");
//		int lastQutosIndex = contentSplitStr[2].lastIndexOf("\"");
//		uploadFileName = contentSplitStr[2].substring(lastPathSeparatorIndex+1, lastQutosIndex);
//		return uploadFileName;
		
	
		private String getUploadFileName(String contentDisposition) {
			// TODO Auto-generated method stub
			String uploadFileName = null;
			String[] contentSplitStr = contentDisposition.split(";");
			int firstQutosIndex = contentSplitStr[2].indexOf("\"");
			int lastQutosIndex = contentSplitStr[2].lastIndexOf("\"");
			uploadFileName = contentSplitStr[2].substring(firstQutosIndex + 1, lastQutosIndex);
			return uploadFileName;

		}
		
	}