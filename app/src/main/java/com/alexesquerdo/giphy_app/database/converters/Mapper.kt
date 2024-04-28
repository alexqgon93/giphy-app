package com.alexesquerdo.giphy_app.database.converters

import com.alexesquerdo.giphy_app.database.models.AnalyticsEntity
import com.alexesquerdo.giphy_app.database.models.GiphyItemEntity
import com.alexesquerdo.giphy_app.database.models.ImagesEntity
import com.alexesquerdo.giphy_app.database.models.MeasuresEntity
import com.alexesquerdo.giphy_app.database.models.MetaEntity
import com.alexesquerdo.giphy_app.database.models.OriginalEntity
import com.alexesquerdo.giphy_app.database.models.PaginationEntity
import com.alexesquerdo.giphy_app.database.models.TrendingEntity
import com.alexesquerdo.giphy_app.database.models.UrlEntity
import com.alexesquerdo.giphy_app.database.models.UserEntity
import com.alexesquerdo.giphy_app.domain.common.Measures
import com.alexesquerdo.giphy_app.domain.common.Url
import com.alexesquerdo.giphy_app.domain.models.Analytics
import com.alexesquerdo.giphy_app.domain.models.GiphyItem
import com.alexesquerdo.giphy_app.domain.models.Images
import com.alexesquerdo.giphy_app.domain.models.Meta
import com.alexesquerdo.giphy_app.domain.models.Original
import com.alexesquerdo.giphy_app.domain.models.Pagination
import com.alexesquerdo.giphy_app.domain.models.Trending
import com.alexesquerdo.giphy_app.domain.models.User

fun Trending.toDatabase() = TrendingEntity(
    giphyItems = giphyItems.map { it.toDatabase() },
    meta = meta.toDatabase(),
    pagination = pagination.toDatabase(),
)

fun GiphyItem.toDatabase() = GiphyItemEntity(
    altText = altText,
    analytics = analytics.toDatabase(),
    analyticsResponsePayload = analyticsResponsePayload,
    bitlyGiUrl = bitlyGiUrl,
    bitlyUrl = bitlyUrl,
    contentUrl = contentUrl,
    embedUrl = embedUrl,
    id = id,
    images = images.toDatabase(),
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
    user = user?.toDatabase(),
    username = username
)

fun Images.toDatabase() = ImagesEntity(
    fixedHeight = fixedHeight.toDatabase(),
    fixedHeightDownSampled = fixedHeightDownSampled.toDatabase(),
    fixedHeightSmall = fixedHeightSmall.toDatabase(),
    fixedWidth = fixedWidth.toDatabase(),
    fixedWidthDownSampled = fixedWidthDownSampled.toDatabase(),
    fixedWidthSmall = fixedWidthSmall.toDatabase(),
    original = original.toDatabase(),
)

fun Original.toDatabase() = OriginalEntity(
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

fun Meta.toDatabase() = MetaEntity(msg = msg, responseId = responseId, status = status)

fun Pagination.toDatabase() = PaginationEntity(
    count = count,
    offset = offset,
    totalCount = totalCount
)


fun Analytics.toDatabase() = AnalyticsEntity(
    onClick = onClick.toDatabase(),
    onLoad = onLoad.toDatabase(),
    onSent = onSent.toDatabase(),
)

fun Measures.toDatabase() = MeasuresEntity(
    height = height,
    mp4 = mp4,
    mp4Size = mp4Size,
    size = size,
    url = url,
    webp = webp,
    webpSize = webpSize,
    width = width
)

fun User.toDatabase() = UserEntity(
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

fun Url.toDatabase() = UrlEntity(url = url)
