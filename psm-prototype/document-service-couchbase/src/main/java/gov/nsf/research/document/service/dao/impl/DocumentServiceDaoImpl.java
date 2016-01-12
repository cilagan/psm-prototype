package gov.nsf.research.document.service.dao.impl;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;

import gov.nsf.research.document.service.dao.DocumentServiceDao;
import gov.nsf.research.document.service.dao.FileStoreDao;
import gov.nsf.research.document.service.dao.MetaDataServiceDao;
import gov.nsf.research.document.service.model.DocumentMetaData;
import gov.nsf.research.document.service.model.SectionType;
import gov.nsf.research.document.service.pdf.DocServiceUtility;

public class DocumentServiceDaoImpl implements DocumentServiceDao {

	@Autowired
	MetaDataServiceDao metadataServiceDao;
	
	@Autowired
	FileStoreDao fileStoreDao;
	
	@Override
	public DocumentMetaData saveDocument(InputStream inputStream, String tempPropId, SectionType sectionType) {
		
		/**
		 * Pseudo-code:
		 * - create metadata object	
		 * - call docmetadao - save
		 * - call S3 uploadfile
		 * - send back document metadata
		 */
		DocumentMetaData docMetaData = null;
		
		try {
			docMetaData = DocServiceUtility.assembleMetaData(inputStream, tempPropId, sectionType);
			metadataServiceDao.saveDocumentMetaData(docMetaData);
			fileStoreDao.uploadFile(inputStream, docMetaData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return docMetaData;
	}

	@Override
	public ByteArrayOutputStream viewDocument(String tempPropId, SectionType sectionType, int seqNum) {
		//TODO: fileStoreDao need to return ByteArrayOutputStream
		ByteArrayOutputStream out = (ByteArrayOutputStream) fileStoreDao.downloadFile(DocServiceUtility.getFileName(tempPropId, sectionType));
		return out;
	}

	@Override
	public DocumentMetaData getDocumentMetaData(String tempPropId, SectionType sectionType, int seqNum) {
		return metadataServiceDao.viewDocumentMetaData(DocServiceUtility.getKey(tempPropId, sectionType));
	}
	
	@Override
	public boolean isDocumentExists(String tempPropId, SectionType sectionType, int seqNum) {
		//TODO: Where is the check on metaDataServiceDao?
		return fileStoreDao.checkFileExist(DocServiceUtility.getFileName(tempPropId, sectionType));
	}

	@Override
	public boolean deleteDocument(String tempPropId, SectionType sectionType, int seqNum) {
		 
		boolean metaDataDelete = metadataServiceDao.deleteDocumentMetaData(DocServiceUtility.getKey(tempPropId, sectionType));
		boolean fileStoreDelete = fileStoreDao.deleteFile(DocServiceUtility.getFileName(tempPropId, sectionType));

		return (metaDataDelete && fileStoreDelete);
	}
}
