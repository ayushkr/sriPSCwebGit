/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.srisrisri.psc.FileStorage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author akr
 */
@Repository
public interface FileStoreRepo extends JpaRepository<FileStoreEntity,Long> {

}
    
