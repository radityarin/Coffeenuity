package com.ftp.coffeenuity.data.source.remote

import com.ftp.coffeenuity.data.source.remote.network.ApiServiceFuzzyAHP
import com.ftp.coffeenuity.data.source.remote.network.request.AHPRequest
import com.ftp.coffeenuity.data.source.remote.network.response.AHPResponse
import com.ftp.coffeenuity.data.utils.Resource
import com.ftp.coffeenuity.domain.model.QuestionerPetani
import com.ftp.coffeenuity.domain.model.QuestionerRoastery
import com.ftp.coffeenuity.domain.model.QuestionerTengkulak
import com.ftp.coffeenuity.domain.model.User
import com.ftp.coffeenuity.utils.Constants
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await
import timber.log.Timber

class RemoteDataSource(
    private val firebaseAuth: FirebaseAuth,
    private val apiServiceFuzzyAHP: ApiServiceFuzzyAHP
) {

    private val mUsersCollection =
        FirebaseFirestore.getInstance().collection(Constants.COLLECTION_USER)
    private val mQuestionerPetaniCollection =
        FirebaseFirestore.getInstance().collection(Constants.COLLECTION_QUESTIONER_PETANI)
    private val mQuestionerRoasteryCollection =
        FirebaseFirestore.getInstance().collection(Constants.COLLECTION_QUESTIONER_ROASTERY)
    private val mQuestionerTengkulakCollection =
        FirebaseFirestore.getInstance().collection(Constants.COLLECTION_QUESTIONER_TENGKULAK)

    fun getAllQuestionerPetani() = flow<Resource<List<QuestionerPetani>>> {
        val snapshot = mQuestionerPetaniCollection.get().await()
        val questioners = snapshot.toObjects(QuestionerPetani::class.java)
        emit(Resource.Success(questioners))
    }.catch {
        emit(Resource.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)

    fun getAllQuestionerTengkulak() = flow<Resource<List<QuestionerTengkulak>>> {
        val snapshot = mQuestionerTengkulakCollection.get().await()
        val questioners = snapshot.toObjects(QuestionerTengkulak::class.java)
        emit(Resource.Success(questioners))
    }.catch {
        emit(Resource.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)

    fun getAllQuestionerRoastery() = flow<Resource<List<QuestionerRoastery>>> {
        val snapshot = mQuestionerRoasteryCollection.get().await()
        val questioners = snapshot.toObjects(QuestionerRoastery::class.java)
        emit(Resource.Success(questioners))
    }.catch {
        emit(Resource.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)

    fun getListQuestionerPetaniWithSpecificID(idUser: String) =
        flow<Resource<List<QuestionerPetani>>> {
            val snapshot =
                mQuestionerPetaniCollection.whereEqualTo(
                    Constants.COLLECTION_GENERAL_ATTRIBUTE_ID_USER,
                    idUser
                )
                    .get().await()
            val story = snapshot.toObjects(QuestionerPetani::class.java)
            emit(Resource.Success(story))
        }.catch {
            emit(Resource.Error(it.message.toString()))
        }.flowOn(Dispatchers.IO)

    fun getListQuestionerTengkulakWithSpecificID(idUser: String) =
        flow<Resource<List<QuestionerTengkulak>>> {
            val snapshot =
                mQuestionerTengkulakCollection.whereEqualTo(
                    Constants.COLLECTION_GENERAL_ATTRIBUTE_ID_USER,
                    idUser
                )
                    .get().await()
            val story = snapshot.toObjects(QuestionerTengkulak::class.java)
            emit(Resource.Success(story))
        }.catch {
            emit(Resource.Error(it.message.toString()))
        }.flowOn(Dispatchers.IO)

    fun getListQuestionerRoasteryWithSpecificID(idUser: String) =
        flow<Resource<List<QuestionerRoastery>>> {
            val snapshot =
                mQuestionerRoasteryCollection.whereEqualTo(
                    Constants.COLLECTION_GENERAL_ATTRIBUTE_ID_USER,
                    idUser
                )
                    .get().await()
            val story = snapshot.toObjects(QuestionerRoastery::class.java)
            emit(Resource.Success(story))
        }.catch {
            emit(Resource.Error(it.message.toString()))
        }.flowOn(Dispatchers.IO)

    fun addQuestionerPetani(questionerPetani: QuestionerPetani) = flow<Resource<Boolean>> {
        emit(Resource.Loading())
        mQuestionerPetaniCollection.document(questionerPetani.idQuestioner).set(questionerPetani).await()
        emit(Resource.Success(true))
    }.catch {
        emit(Resource.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)

    fun addQuestionerTengkulak(questionerTengkulak: QuestionerTengkulak) = flow<Resource<Boolean>> {
        emit(Resource.Loading())
        mQuestionerTengkulakCollection.document(questionerTengkulak.idQuestioner).set(questionerTengkulak).await()
        emit(Resource.Success(true))
    }.catch {
        emit(Resource.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)

    fun addQuestionerRoastery(questionerRoastery: QuestionerRoastery) = flow<Resource<Boolean>> {
        emit(Resource.Loading())
        mQuestionerRoasteryCollection.document(questionerRoastery.idQuestioner).set(questionerRoastery).await()
        emit(Resource.Success(true))
    }.catch {
        emit(Resource.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)

    suspend fun getIndeksKeberlanjutanPetani(AHPRequest: AHPRequest): Flow<AHPResponse> {
        return flow {
            try {
                val response =
                    apiServiceFuzzyAHP.getIndeksKeberlanjutanPetani(AHPRequest = AHPRequest)
                if (response.message.isNotBlank()) {
                    emit(response)
                }
            } catch (e: Exception) {
                Timber.e(e.message.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    fun loginUser(email: String, password: String) = flow<Resource<AuthResult>> {
        emit(Resource.Loading())
        val loginAuth = firebaseAuth.signInWithEmailAndPassword(email, password).await()
        emit(Resource.Success(loginAuth))
    }.catch {
        emit(Resource.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)

    fun registerUser(email: String, password: String) = flow<Resource<AuthResult>> {
        emit(Resource.Loading())
        val registerAuth = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
        emit(Resource.Success(registerAuth))
    }.catch {
        emit(Resource.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)

    fun addUser(user: User) = flow<Resource<Boolean>> {
        emit(Resource.Loading())
        mUsersCollection.document(user.idUser).set(user).await()
        emit(Resource.Success(true))
    }.catch {
        emit(Resource.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)

    fun getUserWithIDUser(idUser: String) = flow<Resource<User>> {
        val snapshot =
            mUsersCollection.document(idUser)
                .get().await()
        val user = snapshot.toObject(User::class.java)
        if (user != null) {
            emit(Resource.Success(user))
        }
    }.catch {
        emit(Resource.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)

}