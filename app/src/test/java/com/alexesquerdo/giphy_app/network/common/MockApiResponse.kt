package com.alexesquerdo.giphy_app.network.common

import okhttp3.mockwebserver.MockResponse

class MockApiResponse {

    companion object {
        private const val SUCCESS = 200
        private const val ERROR = 400

        fun serviceTrendingSuccess(): MockResponse =
            MockResponse().setBody(ResponseStubs.getResponseTrendingSuccess())
                .setResponseCode(SUCCESS)

        fun serviceTrendingError(): MockResponse =
            MockResponse().setBody(ResponseStubs.getResponseError())
                .setResponseCode(ERROR)
    }
}