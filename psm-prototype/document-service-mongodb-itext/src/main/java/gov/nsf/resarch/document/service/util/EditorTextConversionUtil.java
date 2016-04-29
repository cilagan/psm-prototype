package gov.nsf.resarch.document.service.util;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

import gov.nsf.research.document.service.model.EditorFormat;
import gov.nsf.research.document.service.model.EditorText;

public class EditorTextConversionUtil {

	
	/**
	 * 
	 * 	<p> - paragraph
	 * 	&nbsp; - space
	 * 	<strong> - bold
	 * 	<em> - italicized
	 * 	<u> - underlined
	 * 
	 */
	
	public static Set<EditorText> convertEditorString(String input){
		Set<EditorText> textStore = new LinkedHashSet<EditorText>(); 
		
		if(input == null){
			return null;
		}
		
		String filteredInput = (input.replaceAll("&nbsp;", " "))
				.replaceAll("<p>", " ")
				.replaceAll("</p>", " ");
		
		StringTokenizer st = new StringTokenizer(filteredInput, "<>", true);
		
		while (st.hasMoreElements()) {
			String text = st.nextElement().toString();
			
			if("<".equals(text)){
				String tag = st.nextElement().toString();
				/** text has formatting */
				if("strong".equals(tag)){
					st.nextElement(); // closing >
					String content = st.nextElement().toString();
					EditorText boldText = new EditorText(content, EditorFormat.BOLD);
					textStore.add(boldText);
					/** outer tag */
					if("<".equals(st.nextElement().toString())){
						if("/strong".equals(st.nextElement())){
							st.nextElement();
						}
					}
				} else if("em".equals(tag)){
					st.nextElement(); // closing >
					String content = st.nextElement().toString();
					EditorText boldText = new EditorText(content, EditorFormat.ITALIC);
					textStore.add(boldText);
					/** outer tag */
					if("<".equals(st.nextElement().toString())){
						if("/em".equals(st.nextElement())){
							st.nextElement();
						}
					}
				} else if("u".equals(tag)){
					st.nextElement(); // closing >
					String content = st.nextElement().toString();
					EditorText boldText = new EditorText(content, EditorFormat.UNDERLINED);
					textStore.add(boldText);
					/** outer tag */
					if("<".equals(st.nextElement().toString())){
						if("/u".equals(st.nextElement())){
							st.nextElement();
						}
					}
				} 
			} else { 
				EditorText normalText = new EditorText(text, EditorFormat.PLAIN);
				textStore.add(normalText);
			}
		}
		return textStore;
	}	
}