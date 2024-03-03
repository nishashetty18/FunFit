package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ParticipantsDao;
import Models.Participants;




/**
 * Servlet implementation class Participants
 */
@WebServlet("/")
public class ParticipantsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ParticipantsDao participantsdao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParticipantsServlet() {
    	participantsdao=new ParticipantsDao();
    }
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getServletPath();
		switch(action) 
		{
		case "/new":
			showNewForm(request, response);
			break;		
		
		case "/insert":
			try {
				insert(request, response);
			} catch (SQLException e) {
				System.out.println("inserted");
				e.printStackTrace();
			} 
			break;
		
		case "/delete":
			delete(request, response);
			break;
		case "/edit":
			showEditForm(request, response);
			break;
		case "/update":
			System.out.println("update block");
			try {
				update(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (IOException e) {
				
			}catch (Exception e) {
				
			}
			break;
			
		case "/list":
			try {
				viewlist(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		
		}
	}

	



	private void viewlist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
	try {
		List<Participants> viewlist=participantsdao.viewAll();
		request.setAttribute("viewlist", viewlist);
		RequestDispatcher dispatcher=request.getRequestDispatcher("participants.jsp");
		dispatcher.forward(request, response);
		}catch(Exception e) {
			
		}
		
	}
		
		
	



	
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		try{
			int id=Integer.parseInt(request.getParameter("id"));
		
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		String location=request.getParameter("location");
		String phone=request.getParameter("phone");
		int batch_id=Integer.parseInt(request.getParameter("batch_id"));
		Participants part=new Participants(id, name, gender, location, phone, batch_id);
		System.out.println(part);
		participantsdao.updateParticipants(part);
		
		response.sendRedirect("list");
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}



	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id=Integer.parseInt(request.getParameter("id"));
		Participants existing=participantsdao.searchParticipantsbyId(id);
		try {
			//existing=batch1dao.searchParticipantsbyId(pId);
			RequestDispatcher dispatcher=request.getRequestDispatcher("form_part.jsp");
			request.setAttribute("part", existing);
			dispatcher.forward(request, response);
		}catch(Exception e) {
			
		}
		
	}



	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		try {
			participantsdao.deleteParticipants(id);
		}catch(Exception e) {
			
		}
		response.sendRedirect("list");
		
	}



	private void insert(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
	
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		String location=request.getParameter("location");
		String phone=request.getParameter("phone");
		int batch_id=Integer.parseInt(request.getParameter("batch_id"));
		Participants part=new Participants(name,gender,location, phone,batch_id);
		
		
		participantsdao.AddParticipants(part);
		response.sendRedirect("list");
		
	}



	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=request.getRequestDispatcher("form_part.jsp");
		dispatcher.forward(request, response);
		
		
	}
	

	



	}

	
	


