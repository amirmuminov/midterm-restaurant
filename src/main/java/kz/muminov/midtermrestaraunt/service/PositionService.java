package kz.muminov.midtermrestaraunt.service;

import kz.muminov.midtermrestaraunt.dao.PositionDAO;
import kz.muminov.midtermrestaraunt.entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PositionService {

    private PositionDAO positionDAO;

    @Autowired
    public PositionService(PositionDAO positionDAO) {
        this.positionDAO = positionDAO;
    }

    //Method which calling dao method for creating new position
    public void createPosition(Position position){
        int affectedRows = positionDAO.createPosition(position);
        System.out.println("Affected rows: " + affectedRows);
    }

    //Method which passes id in the dao method for deleting position
    public void deletePosition(Long id){
        int affectedRows = positionDAO.deletePosition(id);
        System.out.println("Affected rows: " + affectedRows);
    }

    //Method which receives list of categories to print all categories
    public void getAllPositions(){
        for (Position position: positionDAO.getAllPositions()){
            System.out.println(position.getId() + ". " + position.getName());
        }
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
    }

}
