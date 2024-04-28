package com.alexesquerdo.giphy_app.data.mappers

import com.alexesquerdo.giphy_app.domain.common.Measures
import com.alexesquerdo.giphy_app.domain.models.Analytics
import com.alexesquerdo.giphy_app.domain.models.Images
import com.alexesquerdo.giphy_app.domain.models.Meta
import com.alexesquerdo.giphy_app.domain.common.Url
import com.alexesquerdo.giphy_app.domain.models.GiphyItem
import com.alexesquerdo.giphy_app.domain.models.Original
import com.alexesquerdo.giphy_app.domain.models.Pagination
import com.alexesquerdo.giphy_app.domain.models.Trending
import com.alexesquerdo.giphy_app.domain.models.User
import com.alexesquerdo.giphy_app.network.responses.trending.NetworkAnalytics
import com.alexesquerdo.giphy_app.network.responses.common.NetworkMeasures
import com.alexesquerdo.giphy_app.network.responses.trending.NetworkImages
import com.alexesquerdo.giphy_app.network.responses.trending.NetworkMeta
import com.alexesquerdo.giphy_app.network.responses.common.NetworkUrl
import com.alexesquerdo.giphy_app.network.responses.trending.NetworkGiphyItem
import com.alexesquerdo.giphy_app.network.responses.trending.NetworkOriginal
import com.alexesquerdo.giphy_app.network.responses.trending.NetworkPagination
import com.alexesquerdo.giphy_app.network.responses.trending.NetworkTrending
import com.alexesquerdo.giphy_app.network.responses.trending.NetworkUser

fun NetworkTrending.toDomainModel() = Trending(
    giphyItems = giphyItem.map { it.toDomainModel() },
    meta = meta.toDomainModel(),
    pagination = pagination.toDomainModel()
)

fun NetworkGiphyItem.toDomainModel() = GiphyItem(
    altText = altText,
    analytics = analytics.toDomainModel(),
    analyticsResponsePayload = analyticsResponsePayload,
    bitlyGiUrl = bitlyGifUrl,
    bitlyUrl = bitlyUrl,
    contentUrl = contentUrl,
    embedUrl = embedUrl,
    id = id,
    images = images.toDomainModel(),
    importDatetime = importDatetime,
    isSticker = isSticker,
    rating = rating,
    slug = slug,
    source = source,
    sourcePostUrl = sourcePostUrl,
    sourceTld = sourceTld,
    title = title,
    trendingDatetime = trendingDatetime,
    type = type,
    url = url,
    user = user?.toDomainModel(),
    username = username
)

fun NetworkMeta.toDomainModel() = Meta(msg = msg, responseId = responseId, status = status)

fun NetworkPagination.toDomainModel() = Pagination(
    count = count,
    offset = offset,
    totalCount = totalCount
)

fun NetworkAnalytics.toDomainModel() = Analytics(
    onClick = onClick.toDomainModel(),
    onLoad = onLoad.toDomainModel(),
    onSent = onSent.toDomainModel(),
)

fun NetworkImages.toDomainModel() = Images(
    fixedHeight = fixedHeight.toDomainModel(),
    fixedHeightDownSampled = fixedHeightDownSampled.toDomainModel(),
    fixedHeightSmall = fixedHeightSmall.toDomainModel(),
    fixedWidth = fixedWidth.toDomainModel(),
    fixedWidthDownSampled = fixedWidthDownSampled.toDomainModel(),
    fixedWidthSmall = fixedWidthSmall.toDomainModel(),
    original = original.toDomainModel(),
)

fun NetworkUser.toDomainModel() = User(
    avatarUrl = avatarUrl,
    bannerImage = bannerImage,
    bannerUrl = bannerUrl,
    description = description,
    displayName = displayName,
    instagramUrl = instagramUrl,
    isVerified = isVerified,
    profileUrl = profileUrl,
    username = username,
    websiteUrl = websiteUrl
)

fun NetworkUrl.toDomainModel() = Url(url = url)

fun NetworkMeasures.toDomainModel() = Measures(
    height = height,
    mp4 = mp4,
    mp4Size = mp4Size,
    size = size,
    url = url,
    webp = webp,
    webpSize = webpSize,
    width = width
)

fun NetworkOriginal.toDomainModel() = Original(
    frames = frames,
    hash = hash,
    height = height,
    mp4 = mp4,
    mp4Size = mp4Size,
    size = size,
    url = url,
    webp = webp,
    webpSize = webpSize,
    width = width
)