package com.todolist.rest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.dto.FolderDTO;
import com.todolist.dto.FolderFullDTO;
import com.todolist.model.Folder;
import com.todolist.service.FolderService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("folders")
public class FolderRest {
	
	@Autowired
	private FolderService folderService;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@PostMapping("/insertar")
	public FolderDTO insertar(@RequestBody FolderDTO folderDTO){
		Folder folder = convertToEntity(folderDTO);
		Folder folderCreated = folderService.insertar(folder);
        return convertToDto(folderCreated);
	}
	
	@GetMapping("/listar")
	public List <FolderDTO> listar() {
		List<Folder> folders = folderService.listar();
		return folders.stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}
	
	@GetMapping("/listar/{id}")
	public Optional<FolderFullDTO> listarID(@PathVariable("id") int idFolder) {
		Optional<Folder> folders = folderService.listarID(idFolder);
		return folders.stream()
				.map(this::convertToFullDto)
				.findFirst();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") int idFolder) {
		folderService.eliminar(idFolder);
	}
	
	@PutMapping("/actualizar")
	public FolderFullDTO actualizar(@RequestBody FolderDTO folderDTO) {
		Folder folder = convertToEntity(folderDTO);
		System.out.println(folder);
		Folder folderUpdated = folderService.actualizar(folder);
		return convertToFullDto(folderUpdated);
	}
	
	private FolderFullDTO convertToFullDto(Folder folder) {
	    FolderFullDTO folderDTO = modelMapper.map(folder, FolderFullDTO.class);
	    return folderDTO;
	}
	
	private FolderDTO convertToDto(Folder folder) {
	    FolderDTO folderDTO = modelMapper.map(folder, FolderDTO.class);
	    return folderDTO;
	}
	
	private Folder convertToEntity(FolderDTO folderDTO) {
	    Folder folder = modelMapper.map(folderDTO, Folder.class);
	    return folder;
	}
}
