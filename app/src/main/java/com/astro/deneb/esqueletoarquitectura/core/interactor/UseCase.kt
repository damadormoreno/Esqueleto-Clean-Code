package com.astro.deneb.esqueletoarquitectura.core.interactor

import com.astro.deneb.esqueletoarquitectura.core.exception.Failure
import com.astro.deneb.esqueletoarquitectura.core.functional.Either
import kotlinx.coroutines.*

abstract class UseCase<out Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): Either<Failure, Type>

    operator fun invoke(params: Params, onResult: (Either<Failure, Type>) -> Unit = {}) {
        GlobalScope.launch(Dispatchers.Main) {
            val job = async(Dispatchers.IO) { run(params) }
            onResult(job.await())
        }
    }

    class None
}