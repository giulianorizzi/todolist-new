package com.todolist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.dao.FolderDAO;
import com.todolist.model.Folder;

@Service
public class FolderService {
	 @Autowired
	 private FolderDAO folderDAO;
	 	 
	 public List<Folder> listar() {
		 return folderDAO.findAll();
	 }
	 
	 public Optional<Folder> listarID(int idFolder) {
		 return folderDAO.findById(idFolder);	
	 }
		
	 public Folder insertar(Folder folder) {
		return folderDAO.save(folder);
	 }
	 
	 public void eliminar(int idFolder) {
		folderDAO.deleteById(idFolder);
	 }
	 
	 public Folder actualizar(Folder folder) {
		if(folderDAO.existsById(folder.getIdFolder())) {
			return folderDAO.save(folder);
		} else {
			return null;
		}
	}
}
