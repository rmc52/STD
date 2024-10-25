package jhctpj.service;

import static jhctpj.common.jdbctemplate.close;
import static jhctpj.common.jdbctemplate.commit;
import static jhctpj.common.jdbctemplate.getConnection;
import static jhctpj.common.jdbctemplate.rollback;

import java.sql.Connection;

import jhctpj.common.jdbctemplate;
import jhctpj.dao.stddao;
import jhctpj.dto.stdnt;



public class stdservice {

	private stddao dao = new stddao();

	
	
	
	//조회
	
	public stdnt selectstdnt(String input) {
		
		Connection conn = getConnection();
		
		
		stdnt stdnt = dao.selectstdnt(conn, input);
		
		jdbctemplate.close(conn);
		
		
		return stdnt; 
	}
	
	
	
	
	
	//등록
	
public int insertstdnt(stdnt stdnt) throws Exception{
		
		Connection conn = getConnection();
		
		
		int result = dao.insertstdnt(conn, stdnt);
		
	
		if(result > 0) { 
			commit(conn);
			
		} else { 
			rollback(conn);
			
		}
		
		
		close(conn);
		
		
		return result;
	}





public int deleteStdnt(String input) throws Exception {
	
	Connection conn = getConnection();
	
	int result = dao.deleteStdnt(conn, input);
	
	// 결과에 따라 트랜잭션 제어 처리
	if(result >0 ) {
		commit(conn);
	} else {
		rollback(conn);
	}
	
	close(conn);
	
	return result;
}



	
	
	
	
	
	
	
	
}
