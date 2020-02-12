package com.astro.deneb.esqueletoarquitectura.core.exception

sealed class Failure {
    object NetWorkConnection : Failure()
    object ServerError: Failure()
    object CastObjectException: Failure()
    data class CustomError(val errorCode: Int, val errorMessage: String?): Failure()
    /** * Extend this class for feature specific failures.*/
    abstract class FeatureFailure: Failure()

}