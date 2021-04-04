package com.sist.r;

import org.rosuda.REngine.Rserve.RConnection;
import org.springframework.stereotype.Component;

@Component
public class RManager {
	public void rGraph(){
		try{
		RConnection rc=new RConnection();
		rc.voidEval("library(KoNLP)");//library => �ڹ� import�� ���� ��
		rc.voidEval("library(wordcloud)");//wordcloud import
		rc.voidEval("board<-readLines(\"c:/data/board.txt\")");
		//������ �׸����� ����������
		rc.voidEval("png(\"C:/springDev/springStudy/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SpringBoardProject/main/r.png\")");
		
		//����
		rc.voidEval("data<-sapply(board,extractNoun,USE.NAMES = F)");
		rc.voidEval("data2<-unlist(data)");
		rc.voidEval("data3<-table(data2)");
		rc.voidEval("data4<-head(sort(data3,decreasing = TRUE),10)");
		//���ٿ� �׷����� �ΰ��� �׷��� (row,column)
		rc.voidEval("par(mfrow=c(2,2))");
		rc.voidEval("pie(data4,col=rainbow(10))");
		rc.voidEval("barplot(data4,col=rainbow(10))");
		rc.voidEval("hist(data4)");
		rc.voidEval("wordcloud(names(data4),freq=data4,min.freq = 2,scale=c(5,0.5),random.order = TRUE,rot.per = 0.1,colors = rainbow(15))");
		rc.voidEval("dev.off()");
		rc.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
}
