package com.project.passwordmanager.model

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * This interface serves as the Data Access Object (DAO) for the Credential entity.
 * It provides methods to interact with the credentials_table in the database.
 */
@Dao
interface CredentialDao {

    /**
     * Inserts a new credential into the credentials_table.
     *
     * @param credential The Credential object to be inserted.
     */
    @Insert
    suspend fun insert(credential: Credential)

    /**
     * Updates an existing credential in the credentials_table.
     *
     * @param credential The updated Credential object.
     */
    @Update
    suspend fun update(credential: Credential)

    /**
     * Deletes a credential from the credentials_table.
     *
     * @param credential The Credential object to be deleted.
     */
    @Delete
    suspend fun delete(credential: Credential)

    /**
     * Retrieves all the credentials from the credentials_table in ascending order by ID.
     * The result is wrapped in a LiveData object, allowing for automatic updates in the UI.
     *
     * @return A LiveData object containing a list of all credentials.
     */
    @Query("SELECT * FROM credentials_table ORDER BY id ASC")
    fun getAll(): LiveData<List<Credential>>
}
